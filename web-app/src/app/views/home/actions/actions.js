import * as types from './actionTypes'
import instance from '../../../services/api';

export const getUser = () => dispatch => {  
  dispatch({
    type: types.GET_USER_NAME
  })
}

export const getData = () => dispatch => {
  instance.get("/amendment").then(res => {
    console.log("DATA: ", res);
    dispatch({
      type: types.GET_DATA,
      payload: res
    });
  }).catch(err => {
      console.log(err);
  });
}