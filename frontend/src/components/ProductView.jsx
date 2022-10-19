import React from 'react'
import styled from 'styled-components';
import Footer from './Footer';
import Header from './Header';
import Rating from '@material-ui/lab/Rating';
import { useStateValue } from '../StateProvider';

const ProductView = () => ({ id, image, price, rating, title, author, category }) => {

  const [{ basket }, dispatch] = useStateValue()

  const addToBasket = (e) => {
      e.preventDefault()
      console.log('basket >>>', basket)
      dispatch({
          type: 'ADD_TO_BASKET',
          item: {
              id,
              title,
              author,
              category: {},
              price,
              image,
              rating,
          },
      });
  };
 
  return (
    <Container>
      <Header />
      <ProductContainer>
        <Info>
          <img src={image} alt="" />
          <h2>{title} </h2>
          <Rating name="half-rating-read" defaultValue={3} precision={0.5} readOnly />
          <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatem possimus dicta deleniti, ad excepturi sequi ducimus quo, amet deserunt minima voluptatibus. Earum distinctio temporibus eveniet cumque veniam eos cum libero.</p>
          <h4>{author}</h4>
          <h3>2019</h3>
          <h2>R$ {price}</h2>
          <h2>{category}</h2>
          <h2></h2>
        </Info>
        </ProductContainer>
      <Footer />
    </Container>
  )
}

const Container = styled.div`
  width: 100%;
`;

const ProductContainer = styled.div`
  width: 100%;
  margin: 100px 200px 100px 200px;
`;

const Info = styled.div`
  img{
    width: 300px;
    height: 400px;
  }
`;


export default ProductView