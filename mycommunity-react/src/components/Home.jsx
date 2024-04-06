import React, { useEffect, useState } from 'react'
import AppList from './AppList'
import { serverApi } from '../serverApi'
import { useAuth } from 'react-oidc-context';

function invokeAgent(agentInfo){
  console.log("send invoke agent event " + agentInfo);
  window.api.invokeAgent(agentInfo);
}


function Home({userId}) {

  const [apps, setApps] = useState([])
  const [hasError, setHasError] = useState(false)
  const [hasFinished, setHasFinished] = useState(false)

  const auth = useAuth();

  useEffect(()=>{
    serverApi.getUserAuthApp(userId, auth.user?.access_token)
      .then((result)=>{
        setApps(result)
        setHasFinished(true)
      })
      .catch((error)=>{
        console.log("get user auth apps failed, error:" + error)
        setHasError(true)
      })
  },[])

  if(!hasFinished){
    return (
      <div className="ui container" style={{paddingTop:'30px'}}>
        <h1>正在获取授权应用，请稍等......</h1>
      </div>
    )
  }else if(hasError){
    //todo:show error page
  }else{
    return (
      <div className="ui container" style={{paddingTop:'30px'}}>
        <AppList apps={apps}/>
      </div>
    )
  }
}

export default Home