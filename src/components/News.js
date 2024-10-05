import React, { Component }from 'react'
import NewsItem from './NewsItem';
import Spinner from './Spinner';
import PropTypes from 'prop-types';


export class News extends Component {
static defaultProps={
  pagesize:5,
  category:'general'
}
static propTypes={
  pagesize:PropTypes.number,
  category:PropTypes.string
}

  constructor(){
    super();
    this.state={
      articles:[],
      loading:false,
      page:1
    }
  }
  
  async componentDidMount(){
    let url=`https://newsapi.org/v2/top-headlines?category=${this.props.category}&apiKey=05bec729897d47cda4e6f21f877426a5&pagesize=${this.props.pagesize}`;
    this.setState({loading:true});
    let data= await fetch(url);
    let parseddata=await data.json()
    this.setState({articles: parseddata.articles,
      totalArticles:parseddata.totalResults,
    loading:false
    });
  }
  handleprevclick=async ()=>{
    let url=`https://newsapi.org/v2/top-headlines?category=${this.props.category}&apiKey=05bec729897d47cda4e6f21f877426a5&page=${this.state.page-1}&pagesize=${this.props.pagesize}`;
    this.setState({loading:true});
    let data= await fetch(url);
    let parseddata=await data.json()
    this.setState({
      page:this.state.page-1,
      articles: parseddata.articles,
      loading:false
    });
  }
  handlenextclick=async ()=>{
    if(this.state.page+1> Math.ceil(this.state.totalResults/this.props.pagesize))
    {

    }
    else
       {
        let url=`https://newsapi.org/v2/top-headlines?category=${this.props.category}&apiKey=05bec729897d47cda4e6f21f877426a5&page=${this.state.page+1}&pagesize=${this.props.pagesize}`;
        this.setState({loading:true});
        let data= await fetch(url);
        let parseddata=await data.json()
        this.setState({
          page:this.state.page+1,
          articles: parseddata.articles,
          loading:false
        });
       }
  }
  render() {
    return (
      <div className='container my-3'>
        <h1 className='text-center'>Latest News</h1>
        {this.state.loading && <Spinner/>}
        <div className='row'>
         {!this.state.loading && this.state.articles.map((element)=>{
            return <div className='col-md-4' key={element.url}>
              <NewsItem  title={element.title?element.title.slice(0,45):""}  description={element.description?element.description.slice(0,88):""} imageurl={element.urlToImage} newsurl={element.url} author={element.author} date={element.publishedAt}/>
            </div>
           }
         )}
        </div>
        <div className='container d-flex justify-content-between'>
        <button type="button" disabled={this.state.page<=1} onClick={this.handleprevclick} className="btn btn-dark">&larr; Previos</button>
        <button type="button" disabled={this.state.page+1> Math.ceil(this.state.totalResults/this.props.pagesize)} onClick={this.handlenextclick} className="btn btn-dark">Next &rarr;</button>
        </div>
      </div>
    )
  }
}

export default News
