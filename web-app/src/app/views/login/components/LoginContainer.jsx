import React from 'react';
import { GOOGLE_AUTH_URL } from '../../../constants';
import LoginComponent from './LoginComponent';

class LoginContainer extends React.Component {
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(event) {
    window.location.href = GOOGLE_AUTH_URL
  }
  render(){
    return (
      <div>
        <LoginComponent
          onSubmit={this.handleSubmit}
          isSubmitting={this.props.isSubmitting}
        />
      </div>
    )
  }
}

export default LoginContainer;