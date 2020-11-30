export const API_BASE_URL = 'http://localhost:8080';
export const ACCESS_TOKEN = 'oauth2_auth_request';
export const TOKEN = ""

export const OAUTH2_REDIRECT_URI = 'http://localhost:3000/login/google'

export const GOOGLE_AUTH_URL = API_BASE_URL + '/google?redirect_uri=' + OAUTH2_REDIRECT_URI;
