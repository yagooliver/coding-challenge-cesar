import React from 'react';
import {Switch, Route, Redirect} from 'react-router-dom'
import HomeConnect from '../views/home/HomeConnect';
import LoginConnect from '../views/login/LoginConnect';

const checkAuth = () => {
  
    return true;
}

export const Routes = (props) => {
  return (
    <Switch>
      <Route path="/login" component={LoginConnect}/>
    </Switch>
  )
}