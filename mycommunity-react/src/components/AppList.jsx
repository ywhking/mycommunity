import React from 'react'
import AppCard from './AppCard'

function AppList({apps}) {
  let appList = []
  for(let i = 0;i < apps.length; i++){
    appList.push(
      <AppCard key={apps[i].id} app={apps[i]}/>
    )
  };
  return (
    apps.length > 0 ? (
      <div className="ui cards" >
        {appList}
      </div >
    ) : (
        <div className="ui segment">
          <h2 className="ui center header">无可用的应用</h2>
        </div>
      )
  )
}

export default AppList