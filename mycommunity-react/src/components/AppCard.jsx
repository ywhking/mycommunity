import React from 'react'

function openApp(urlAddr){
  console.log("send open-app event " + urlAddr);
  window.api.openApp(urlAddr);
}

function AppCard({app}) {
  return (
    <div className="ui card" onClick={() => openApp(app.urlAddr)}>
      <div className="content">
        <a className="header">{app.name}</a>
        <div className="description">
          {app.desc}
        </div>
      </div>
    </div>
  );
}

export default AppCard