import './App.css';
import React, { Component } from 'react'
import Navbar from './components/Navbar';

import News from './components/News';

import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";

export default class App extends Component {
  render() {
    return (<div>
         <Router>
        <Navbar/>
        <Routes>
          <Route exact path="/" element={<News key="general" pagesize={5} category="general" />}> </Route>
          <Route exact path="/health"element={<News key="health" pagesize={5} category="health" />}>  </Route>
          <Route exact path="/sports" element={<News key="sports" pagesize={5} category="sports" />}></Route>
          <Route exact path="/technology" element={<News key="technology" pagesize={5} category="technology" /> }> </Route>
          <Route exact path="/entertainment" element={<News key="entertainment" pagesize={5} category="entertainment" /> }> </Route>
          <Route exact path="/business" element={<News key="business" pagesize={5} category="business" /> }> </Route>
        </Routes>
    </Router>
    </div>
    
    )
  }
}
