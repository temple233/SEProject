import React from 'react'
import Modal from './SetStock'
import SetStock from './SetStock'
import { npost } from 'q';
import ShowTrade from './ShowTrade'


class StocksList extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            visibleModal: false,
            visibleSet: false,

            stocks : this.props.stock,
            stock_id : 0,
        }
    }

    showModal = (stock_id) => {this.setState( { visibleModal: true, stock_id: stock_id} )}
    handleCloseModal = () => this.setState( { visibleModal: false } )

    showSet = (stock_id) => {this.setState( { visibleSet: true, stock_id: stock_id} )}
    handleCloseSet = () => this.setState( { visibleSet: false } )

    render(){
        return(
            <div>
            <table className="table table-striped">
            <tr>
                <th>Stock_id</th>
                <th>Stock_name</th>
                <th>Current_price</th>
                <th>Type</th>
                <th>Total_amount</th>
                <th>Price_limit</th>
            </tr>
            {
                this.props.stocks.map((stock, index) => {
                    return (
                    <tr key={index}>
                    {stock.map((stockprop, index2) => <td key={index2}>{stockprop}</td>)}

                    <td style={{alignContent:"center" , width:"130px"}}>
                    <button className="btn btn-info btn-sm" onClick={() => this.showSet(stock[0])}>设置</button>
                    &nbsp;
                    <button className="btn btn-info btn-sm" onClick={() => this.showModal(stock[0])}>查看</button>
                    </td>
                    
                    </tr>
                    )
                    }
                )
            }
            <Modal visible={this.state.visibleSet} onClose={ this.handleCloseSet} stock_id={this.state.stock_id} />
            <ShowTrade visible={this.state.visibleModal} onClose={ this.handleCloseModal } stock_id={this.state.stock_id}/>
            </table>
            </div>
            
        )
    }
}

export default StocksList