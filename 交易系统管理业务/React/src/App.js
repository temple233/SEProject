// import React from 'react';
// import './App.css';
// import PropTypes from "prop-types";

// import Login from './Login'

// import { BrowserRouter as Router,Route,Switch,Link} from 'react-router-dom';
// import { withRouter } from 'react-router'

// class App extends React.Component{
//   static contextTypes = {
//     router: PropTypes.object
//   }

//   constructor(props, context){
//     super(props, context);
//     this.handleSubmit = this.handleSubmit.bind(this)

//   }

//   handleSubmit(event){//用户名和密码提交
//     window.location.href="/Login"  
//   }

//   render(){
//     return (
//       <div >
//         <header>
//           <button></button>
//           <Router>
// 					<Route path="/Login" component={Login} />
//           <Link to="/Login/">点击</Link>
//           <button onClick={this.handleSubmit}>123</button>
//           </Router>
//         </header>
//       </div>
//     )
//   }
// }


// export default App;
