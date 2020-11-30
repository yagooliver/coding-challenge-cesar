import React from 'react';
import { Store } from './redux/Store';
import { Provider } from 'react-redux';
import {HashRouter} from 'react-router-dom'
import LoginConnect from './views/login/LoginConnect';
import HomeConnect from './views/home/HomeConnect';
import {ACCESS_TOKEN } from './constants'
import {Switch, Route, Redirect} from 'react-router-dom'
import Cookies from 'js-cookie';

const checkAuth = () => {
  let user = Cookies.get(ACCESS_TOKEN);//localStorageService.getItem(ACCESS_TOKEN);
  console.log("USER:  ",user);
  if(user){
    return true;
  }else{
    return false;
  }
}


const App = () => {
  return (
    <Provider store={Store}>
      <HashRouter>
      <Switch>
        <Route path="/login" component={LoginConnect}/>
        <Route exact path="/" render={(props) => (
          !checkAuth() ? (
            <Redirect to="/login"/> 
          ) : (<HomeConnect/>)
        )} />
      </Switch>
      </HashRouter>
    </Provider>
  )
}

export default App;
