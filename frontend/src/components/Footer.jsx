import React from 'react'
import styled  from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { BsFacebook, BsYoutube, BsTwitter, BsInstagram } from 'react-icons/bs';

function Footer() {

    const navigate = useNavigate()

  return (
    <Container>
        <SocialContainer>
            <Logo onClick={() => navigate('/')}>
                <img src="/whitelogo.png/" alt="" />
            </Logo>           
                        <p>O livro traz a vantagem de a gente poder estar só e ao mesmo tempo acompanhado. Livros não mudam o mundo, quem muda o mundo são as pessoas. Os livros só mudam as pessoas.</p>
                        <h5>Siga-nos</h5>
                        
                        <Socials>
                            <div><BsFacebook /></div>
                            <div><BsYoutube  /></div>
                            <div><BsTwitter /></div>
                            <div><BsInstagram /></div>
                        </Socials>
        </SocialContainer>
    </Container>
  )
}

const Container = styled.div`
    max-width: 100%;
    height: 100%;
    padding: 50px;
    margin-top: 30px;
    background-color: #131921;
    display: flex;
    justify-content: center;
    align-items: center;


    h5{
        color: orange;
    }

    @media only screen and (max-width: 767px){
        flex-direction: column;
        align-items: flex-start;


}


`;

const SocialContainer = styled.div`
    width: 50%;
    color: white;

    h5{
        margin-top: 20px;
    }

    @media only screen and (max-width: 1200px){
        margin-top: 50px;
        height: 100%;
    }

    @media only screen and (max-width: 767px){
        width: 50%;
        margin-top: 50px;
        margin-left: 20%;
    }

    @media only screen and (max-width: 570px){
       margin-left: 15%;
       width: 80%;
    }
`;



const Logo = styled.div`
        cursor: pointer;
        margin-right: 200px;
        margin-left: -50px;

    img{
        width: 300px;     
    }
`;

const Socials = styled.div`
   width: 50%;
   display: flex;
   justify-content: space-between;
   margin-top: 30px;


   
   @media only screen and (max-width: 1200px){
        width: 70%;
    }

       
   @media only screen and (max-width: 870px){
        width: 80%;
    }

    @media only screen and (max-width: 500px){
        width: 90%;
    }

`;

export default Footer;