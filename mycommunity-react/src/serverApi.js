import axios from 'axios'

let instance

async function getUserAuthApp(userId,token) {
    try {
      if(!instance){
        console.log("instance not initialized, start to init ...")
        instance = await initInstance()
      }
      const response = await instance.get('/userauth/1', {
        headers: { 'Authorization': bearerAuth(token) }
      });
      console.log("get user auth app:" + response)
      return Promise.resolve(response.data)
    } catch (error) {
      console.log("get user auth app failed:" + error)
      return Promise.reject(error)
    }
}

function getUserAgent(userId){
    const agentInfo = {
        uuid:"345cfe7e-f3b1-4c64-a2e1-495e0cb7d015",
        proxyAddr:"107.173.30.34",
        proxyPort:"443"
    }
    // const agentInfo = instance.get(`/agent/${userId}`)
    return agentInfo
}

function bearerAuth(token) {
    return `Bearer ${token}`
}

async function initInstance(){
    try{
        const response = await fetch('apiserver.config.json')
        const result = await response.json()

        let instance = axios.create({
            baseURL: result.apiServerUrl
        })
       
        instance.interceptors.response.use(
            response => {
                return response
            }, function (error) {
                if (error.response.status === 404) {
                    return { 
                        status: error.response.status 
                    }
                }
                return Promise.reject(error.response)
            }
        )
        return Promise.resolve(instance)
    }catch(error){
        console.log("init instance failed:" + error)
        return Promise.reject(error)
    }
}

export const serverApi = {
    getUserAgent,
    getUserAuthApp
}
