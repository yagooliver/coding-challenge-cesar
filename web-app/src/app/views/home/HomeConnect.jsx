
import {connect} from 'react-redux';
import HomeContainer from './components/HomeContainer';
import {
  getUser,
  getData
} from './actions/actions';

const mapStateToProps = (state) => ({
  amendments: state.home.amendments
});

const mapDispatchToProps = (dispatch) => ({
  getUser: (item) => dispatch(getUser(item)),
  getData: () => dispatch(getData())
})

export default connect(mapStateToProps, mapDispatchToProps)(HomeContainer);