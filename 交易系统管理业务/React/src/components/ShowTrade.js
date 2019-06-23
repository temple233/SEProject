import React from 'react'
import styled from 'styled-components';
import ReactDOM from 'react-dom';

class ShowTrade extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            visibleModal: false,
        }
    }

    render() {
        const {visible, onClose, stock_id} = this.props
        return visible && ReactDOM.createPortal(
            <StyledModalRoot>
                <div className="box">
                    Stock id : {stock_id}
                    <table className="table table-striped" style={{width:"80%", textAlign:'center'}}>
                        <tr>
                            <th>Stock_id</th>
                            <th>Stock_name</th>
                            <th>Current_price</th>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>123</td>
                            <td>123</td>
                        </tr>
                    </table>
                    <button style={{width:'100px', margin:'0 0 20px 20px'}} className="btn btn-primary" onClick={onClose}>Close</button>
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

export default ShowTrade