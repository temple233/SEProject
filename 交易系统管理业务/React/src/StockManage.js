import React from 'react';
import './StockManage.css'
import StocksList from './components/StocksList'
import History from './common/History'



class StockManage extends React.Component{
    constructor(props){
        super(props);
        this.state={stocks:[["123","123","123","123","123","123"],
        ["123","123","123","123","123","123"],
        ["123","123","123","123","123","123"],
        ["123","123","123","123","123","123"]]}
        fetch("http://localhost:8080/stocks", {
        method: 'POST',
        mode: 'cors', 
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify({
        })
      }).then(res=>res.json()).then(json=>{this.setState({stocks: json})})
        
    }
    render(){
        return (
            <div className="Stock-back">
                <br/>   
                <div style={{ width:"95%"}}>
                <button className='btn btn-danger btn-sm' style={{float:'right' ,width:'100px'}} onClick={() => History.push('/ModifyPwd')}>修改密码</button>
                </div>
                <h3 className="text-center" style={{color:'white'}}>股票管理系统</h3>
                <br/>
                <div className="Stock-container" style={{alignSelf:'center' }}>
                    <StocksList stocks = {this.state.stocks} />
                </div>
            </div>
        )
    }
}

  export default StockManage