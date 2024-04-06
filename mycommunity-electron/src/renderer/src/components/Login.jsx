import React, { useState } from 'react';

function login(urlAddr) {
  console.log("call preload api and login to " + urlAddr);
  window.api.connectMyCommunity(urlAddr);
}

function LoginForm() {

  const [urlAddr, setUrlAddr] = useState("");
  return (
  <div className="login-container" style= {{
    margin: '100px auto',
    width: '300px',
    backgroundColor: '#fff',
    borderRadius: '8px',
    padding: '20px',
    boxShadow: '0 0 10 rgba(0, 0, 0, 0.1)'}}
  >
    <h2 style= {{textAlign:'center'}}>欢迎来到我的社区</h2>
    <label style= {{textAlign:'left'}}>请输入社区地址</label>
    <div>
      <input type="text" defaultValue="https://" onChange={(e)=>setUrlAddr(e.target.value)} style={{
        width: '100%',
        padding: 10,
        marginBottom: 10,
        border: '1px solid #ccc',
        borderRadius: '4px',
        boxSizing: 'border-box'
      }}/>
    </div>
    <div>
      <button className="ui button" onClick={(e)=>login(urlAddr)} style={{
        width: '100%',
        padding: '10px',
        backgroundColor: '#007bff',
        color: '#fff',
        border: 'none',
        borderRadius: '4px',
        cursor: 'pointer',
        transition: 'background-color 0.3s ease'
      }}>
        登录
      </button>
    </div>
  </div>
  );
}

export default LoginForm
