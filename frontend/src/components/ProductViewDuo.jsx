import React from 'react'
import Footer from './Footer';
import Header from './Header';
import Feature from './Feature';
import styled from "styled-components";
import PaymentMethod from './PaymentMethod';
import Api from '../api/Api';
import { useState } from 'react';
import { useEffect } from 'react';

const ProductViewDuo = () => {

  const [livro, setLivro] = useState("");

  useEffect(() => {
    Api.get(`/api/book/id/${1}`).then((response) => {
      console.log(response.data);
      setLivro(response.data);

    }).catch((error) => {
      console.log(error);
    });
  }, [])

  return (
    <Container>
      <Header />
      <ProductContainer>

              <Info>
                <img src="https://images-na.ssl-images-amazon.com/images/I/91yUtx44+AL.jpg" alt="" />
                <h2>{livro.name}</h2>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatem possimus dicta deleniti, ad excepturi sequi ducimus quo, amet deserunt minima voluptatibus. Earum distinctio temporibus eveniet cumque veniam eos cum libero.</p>
                <h4>Author: {livro.author}</h4>
                <h2>R$ {livro.valueBook}</h2>
                <h2>Categoria:</h2>
                <h2></h2>
              </Info>
            

      </ProductContainer>
      <Feature />
      <PaymentMethod />

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

export default ProductViewDuo;

