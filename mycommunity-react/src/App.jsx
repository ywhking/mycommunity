import React, { useEffect, useState } from 'react'
import { AuthProvider } from 'react-oidc-context';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import PrivateRoute from './components/PrivateRoute';
import Home from './components/Home'

 
function App() {

    const [hasError, setHasError] = useState(false)
    const [hasFinished, setHasFinished] = useState(false)
    const [oidcConfig, setOidcConfig] = useState({})

    useEffect(
        () => {
            getOicdParams().then(
                (result)=>{
                    setOidcConfig(result)
                    setHasFinished(true)
                }
            ).catch(
                (error)=>{
                    console.log("getOicdParams failed! error:" + error)
                    setHasError(true)
                }
            )
         },[]
    )

    const router = createBrowserRouter([
        {
            path: "/",
            element: <PrivateRoute>{(userId)=><Home userId = {userId}/>}</PrivateRoute>,
            // loader: homeLoader
        }
    ]);

    if(!hasFinished){
        return (
            <div className="ui container" style={{paddingTop:'30px'}}>
                <h1>正在初始化应用，请稍等......</h1>
            </div>
        )
    }else if(hasError){
        return (
            <div className="ui container" style={{paddingTop:'30px'}}>
                <h1>初始化应用失败，请稍后重试 ......</h1>
            </div>
        )
    }else{
        console.log("show component")
        console.log("parameter is:" + JSON.stringify(oidcConfig))
        return (
            <AuthProvider {...oidcConfig}>
                <RouterProvider router={router} />
            </AuthProvider>
        )
    }
}

async function getOicdParams(){
    try{
        const response = await fetch('oidc.config.json')
        const result = await response.json()
        return result
    }catch(error){
        console.log("getOicdParams failed! error:" + error)
        return Promise.reject(error)
    }
}

export default App