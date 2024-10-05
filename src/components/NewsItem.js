import React, { Component } from 'react'

export class NewsItem extends Component {
  render() {
    let {title,description,imageurl,newsurl,author,date}=this.props;
    return (
      <div className='my-3'>
        <div className="card" style={{width: "18rem"}}>
  <img src={imageurl?imageurl:"https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/MUY4HFCK5ZCA5CI4EC36C44Q7Q.jpg&w=1440"} className="card-img-top" alt="..."/>
  <div className="card-body">
    <h5 className="card-title">{title}</h5>
    <p className="card-text">{description}</p>
    <p className="card-text"><small className="text-muted">By {author?author:"Unknown"} on {new Date(date).toGMTString()}</small></p>
    <a href={newsurl} rel="noopener noreferrer" className="btn btn-sm btn-primary btn-dark">Go somewhere</a>
  </div>
</div>
      </div>
    )
  }
}

export default NewsItem
