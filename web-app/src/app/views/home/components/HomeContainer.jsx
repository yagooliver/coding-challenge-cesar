import React from 'react'
import HomeBody from './HomeBody';
class HomeContainer extends React.Component {
  componentDidMount(){
    this.props.getData()
  }
  render(){
    return (
      <div><h1>Authenticated</h1>
        <HomeBody/>
      </div>
    )
  }
}
export default HomeContainer;