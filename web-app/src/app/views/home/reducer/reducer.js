import * as types from '../actions/actionTypes';

const initialState = {
  amendments: []
}

const HomeReducer = (state = initialState, action) => {
  switch(action.type){
    case types.GET_USER_NAME: 
      return {
        ...state
      }
    case types.GET_DATA:
      return {
        ...state
      }
    default: 
      return state;
  }
}

export default HomeReducer;
