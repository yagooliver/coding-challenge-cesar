import * as types from './actionTypes';

export const submitLogin = (item) => dispatch => {
  dispatch({
    type: types.SUBMIT_CLICK
  });
}