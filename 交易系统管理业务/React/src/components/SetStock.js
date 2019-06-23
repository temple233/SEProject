import React from 'react'
import styled from 'styled-components';
import ReactDOM from 'react-dom';


class Modal extends React.Component {
  
    constructor(props){
        super(props)
        this.state = {
            visibleModal: false,
            stockid : 0
        }
        this.result = false
        //this.handleSubmit = this.handleSubmit.bind(this);
        
    }

    showModal = (stock_id) => {this.setState({visibleModal: true})}
    handleCloseModal = () => this.setState( { visibleModal: false } )

    handleSubmit(stock_id){//用户名和密码提交
        fetch("http://localhost:8080/changestock", {
        method: 'POST',
        mode: 'cors', 
        headers: {
          "Content-Type": "application/json;charset=UTF-8"
        },
        body: JSON.stringify({
          stock_id: stock_id,
          limitUp: this.priceChangeLimitUp.value,
          limitDown: this.priceChangeLimitDown.value,
          isStop: this.isStop.value
        })
      }).then(res=>res.json()).then(json=>{this.result=json})
        if (this.result) {alert("stock change success")}
          else {/*alert("fail")*/}
    }

    render() {
        const {visible, onClose, stock_id} = this.props
        return visible && ReactDOM.createPortal(
        <StyledModalRoot>
            <div className="box">
                Stock ID: {stock_id}
                <input className="form-control" style={{width:'50%', textAlign:'center'}} placeholder="Price Change Up Limitation" ref={ (priceChangeLimitUp)=> {this.priceChangeLimitUp = priceChangeLimitUp}}/>
                <input className="form-control" style={{width:'50%', textAlign:'center'}} placeholder="Price Change Down Limitation" ref={ (priceChangeLimitDown)=> {this.priceChangeLimitDown = priceChangeLimitDown}}/>
                <div >
                    <input type='checkbox' ref={ (isStop)=> {this.isStop = isStop}}></input>
                    <label style={{margin:'0 0 0 10px'}}>STOP TRADE</label>
                </div>      
                <div>
                    <button style={{width:'100px', margin:'0 0 20px 20px'}} className="btn btn-danger" onClick={()=>this.handleSubmit(this.props.stock_id)}>Set</button>
                    <button style={{width:'100px', margin:'0 0 20px 20px'}} className="btn btn-default" onClick={onClose}>Close</button>
                </div>
                
            </div>
        </StyledModalRoot>, document.body)
    }
}

const StyledModalRoot = styled.div`
  position: fixed;
  z-index: 1001;
  left: 0;
  top: 0;
  display: grid;
  place-items: center;
  width: 100%;
  height: 100%;
  background: rgba( 0, 0, 0, 0.2 );

  >.box {
    position: relative;
    display: grid;
    place-items: center;
    width: 40%;
    height: 40%;
    background: white;
    border-radius: 10px;
    box-shadow: 0px 3px 5px -1px rgba(0,0,0,0.2), 0px 5px 8px 0px rgba(0,0,0,0.14), 0px 1px 14px 0px rgba(0,0,0,0.12);
  }
`

export default Modal