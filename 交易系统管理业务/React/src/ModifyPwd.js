import React from 'react';
import './ModifyPwd.css';
import History from './common/History'

class ModifyPwd extends React.Component {
	constructor(props){
        super(props)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

	handleSubmit(event){//用户名和密码提交
		if(this.newPwd2.value != this.newPwd1.value)
			alert('different new Pwd')
		else{
			// pass the password
        alert('change successfully')
		fetch("http://localhost:8080/modifypwd", {
        method: 'POST',
        mode: 'cors', 
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify({
          old: this.oldPwd.value,
          new: this.newPwd2.value
        })
      })
		}
		event.preventDefault()
	}
	
	render() {
		return (
			<div className="App-header">
			<div className="container">
			<form id="login-form">
			  <h3 className="text-center">股票管理系统密码修改</h3>           
			  <div className="form-group">
				<label>please enter original pwd</label>
				<input type="password" className="form-control" placeholder="请输入原密码" ref={(oldPwd)=> {this.oldPwd = oldPwd}} required />
			  </div>
			  <div className="form-group">
				<label>please enter new pwd</label>
				<input type="password" className="form-control" placeholder="请输入新密码" ref={(newPwd)=> {this.newPwd1 = newPwd}} required />
			  </div>
			  <div className="form-group">
				<label>please enter new pwd again</label>
				<input type="password" className="form-control" placeholder="请重新输入新密码" ref={(newPwd)=> {this.newPwd2 = newPwd}} required />
			  </div>
			  <center><button type="submit"  className="btn btn-danger" onClick={this.handleSubmit}>修改</button>&emsp;&emsp;&emsp;&emsp;&emsp;
			  <button type="submit"  className="btn btn-default" onClick={() =>History.push('/StockManage')}>返回</button>
			  </center>
			</form>
			</div>
			</div>
			);
	}
}

export default ModifyPwd;