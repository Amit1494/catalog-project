import { useState, useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'
import ProductList from './ProductList'

function App() {
  const [products,setProducts]=useState([]);
  const [categories,setCategories]=useState([]);
  const [selectedCategory,setSelectedCategory]=useState(null);
  const [searchTerm,setSearchTerm]=useState("");
  const [sortOrder,setsortOrder]=useState("asc");

  useEffect(()=>{
    fetch('http://localhost:8080/api/products')
    .then(response=>response.json())
    .then(data=>setProducts(data));
    fetch('http://localhost:8080/api/categories')
    .then(response=>response.json())
    .then(data=>setCategories(data));
  },[]);
  const handleSearchChange=(event)=>{
    setSearchTerm(event.target.value);
  };

  return (
    <div className='container'>
      <h1 className='my-4'>Product Catalog</h1>
      <div className='row align-items-center mb-4'></div>
      <div className='col-md-3 col-sm-12 mb-12'>
        <p>Categeroy Filter</p>

      </div>
      <div className='col-md-5 col-sm-12 mb-12'>
        <input type="text" className='form-control'
        placeholder="Search For products"
        onChange={handleSearchChange}
        />
      </div>
      <div className='col-md-4 col-sm-12 mb-2'>
        <select className='form-control' onChange={handleSortChange}></select>
      </div>
      <div>
        {products.length ? (
          <ProductList products={products}/>
        ) : (
          <p>No products Found</p>
        )}
      </div>
    </div>
  )
}

export default App