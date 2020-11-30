
import {connect} from 'react-redux';
import LoginContainer from './components/LoginContainer';
import {
  submitLogin
} from './actions/actions';

const mapStateToProps = (state) => ({
  isSubmitting: state.login.isSubmitting
});

const mapDispatchToProps = (dispatch) => ({
  submitLogin: (item) => dispatch(submitLogin(item))
})

export default connect(mapStateToProps, mapDispatchToProps)(LoginContainer);