import { combineReducers } from "redux";
import LoginReducer from '../../views/login/reducer/reducer';
import HomeReducer from '../../views/home/reducer/reducer';

const RootReducer = combineReducers({
  login: LoginReducer,
  home: HomeReducer
});

export default RootReducer;