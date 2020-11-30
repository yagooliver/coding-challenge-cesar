import * as types from '../actions/actionTypes';

const initialState = {
  isSubmitting: false
}

const LoginReducer = (state = initialState, action) => {
  switch(action.type){
    case types.INIT_COMPONENT: 
      return {
        ...initialState
      }
    case types.SUBMIT_CLICK:
      return {
        ...state,
        isSubmitting: false
      }
    default: 
      return state;
  }
}

export default LoginReducer;
