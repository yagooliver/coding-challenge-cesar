import axios from 'axios';
// import Cookies from 'js-cookie';
// import {ACCESS_TOKEN } from '../constants'

const instance = axios.create({
  baseURL: `http://localhost:8080/api`,
  timeout: 180000,
  headers: {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Accept':  '*/*',
    'chave-api-dados': '55f4ffb9b18eef9aff06a2ec76ecacf5',
    // common: {
       //Authorization: `Bearer ${Cookies.get(ACCESS_TOKEN)}`
    //}
  }
});

export default instance;