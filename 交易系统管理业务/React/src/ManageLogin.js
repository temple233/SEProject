import React from 'react'
import './App.css';
import History from './common/History'

class ManageLogin extends React.Component{
    constructor(props){
        super(props)
        this.handleSubmit = this.handleSubmit.bind(this)
        this.result = {}
    }

    handleSubmit(event){//用户名和密码提交
        fetch("http://localhost:8080/login", {
        method: 'POST',
        mode: 'cors', 
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify({
          name: this.account.value,
          password: this.passWord.value
        })
      }).then(res=>res.json()).then(json=>{this.result=json})
        if (this.result.result) {
        History.push('/StockManage')
        } else {
          alert("Error")
        }
        event.preventDefault()
    }

    render(){
        return (
              <div className="App-header">
              <div className="container">
              <form id="login-form">
                <h3 className="text-center">股票管理系统登录</h3>           
                <div className="form-group">
                  <label>account</label>
                  <input type="text" className="form-control" placeholder="Account" ref={ (account)=> {this.account = account}} required />
                </div>
                <div className="form-group">
                  <label>Password</label>
                  <input type="password" className="form-control" placeholder="Password" ref={(passWord) => {this.passWord = passWord}} required />
                </div>
                <center><button type="submit"  className="btn btn-success" onClick={this.handleSubmit}>登录</button></center>
              </form>
              </div>
              </div>
          )
    }
}

export default ManageLogin;