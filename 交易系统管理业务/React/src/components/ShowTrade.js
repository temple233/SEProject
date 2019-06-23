import React from 'react'
import styled from 'styled-components';
import ReactDOM from 'react-dom';

const Trade=[["30","100","2019-06-19","buy"],
["20","100","2019-06-18","buy"],
["20","200","2019-06-18","sell"],
["21","100","2019-06-19","sell"],
["22","300","2019-06-17","sell"],
["26","400","2019-06-16","sell"],
["30","400","2019-06-19","sell"]]
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
                    <table className="table table-striped" style={{width:"80%", textAlign:'center'}}>
                        <tr>
                            <th>Stock_id</th>
                            <th>price</th>
                            <th>amount</th>
                            <th>time</th>
                            <th>buy/sell</th>
                        </tr>
                        {
                            Trade.map((trade, index) => {
                                return (
                                <tr key={index}>
                                <td>{stock_id}</td>
                                {trade.map((tradeInfo, index2) => <td key={index2}>{tradeInfo}</td>)}
                                </tr>
                                )
                                }
                            )
                        }
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
    height:auto;
    background: white;
    border-radius: 10px;
    box-shadow: 0px 3px 5px -1px rgba(0,0,0,0.2), 0px 5px 8px 0px rgba(0,0,0,0.14), 0px 1px 14px 0px rgba(0,0,0,0.12);
  }
`

export default ShowTrade