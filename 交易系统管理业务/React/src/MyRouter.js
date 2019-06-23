import React, { Component } from 'react';
import { Router, Route, Switch } from 'react-router-dom';
import history from './common/History'
import ModifyPwd from './ModifyPwd'
import ManageLogin from './ManageLogin'
import StockManage from './StockManage'

class MyRoute extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route exact path='/' component={ManageLogin} />
                    <Route path='/ModifyPwd' component={ModifyPwd}/>
                    <Route path='/StockManage' component={StockManage}/>
                </Switch>
            </Router>
        );
    }
}

export default MyRoute;