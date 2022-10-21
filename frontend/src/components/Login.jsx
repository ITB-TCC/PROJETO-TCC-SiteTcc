import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components'
import Api from '../api/Api';

const Login = () => {

    const navigate = useNavigate()
    
    const [login, setLogin] = useState("");
    const [senha, setSenha] = useState("");

    const data = {
        login: login,
        senha: senha,
    }

    const onSubmit = async (e) => {
        e.preventDefault();

        await Api.post("/login", data).then((response) => {
            localStorage.setItem("token", response.data.Authorization);
            localStorage.setItem("email", login);
            console.log(login)
            console.log(response.data.Authorization);
            navigate("/");

            alert("deu certo")
        }).catch((error) => {
            console.log(error);
        });
    }
  return (

<Container>
            <Logo Logo onClick={() => navigate('/')}>
                <img src="./logo.png" alt="" />
            </Logo>

            <FormContainer onSubmit={onSubmit}>
                <h3>Login</h3>

                <InputContainer>
                    <p>Email</p>
                    <input onChange={(e) => setLogin(e.target.value)} type="email" placeholder='example@gmail.com' />
                </InputContainer>

                <InputContainer>
                    <p>Senha</p>
                    <input type="Password" onChange={(e) => setSenha(e.target.value)} placeholder='****' />
                </InputContainer>

                <LoginButton>Login</LoginButton>

                <InfoText>Ao continuar, você concorda com as <span>Condições de Uso</span> e <span>Nota de Privacidade </span>do Books9nine.</InfoText>
            </FormContainer>

            <SignUpButton onClick={() => navigate("/signup")}>Criar conta na BookShop</SignUpButton>


        </Container>
  )
}

const Container = styled.div`   
    width: 40%;
    min-width: 450px;
    height: fit-content;
    padding: 15px;
    margin: auto;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;  

const Logo = styled.div`
    cursor: pointer;

    img{
        width: 500px;
    }
`;

const FormContainer = styled.form`
    border: 1px solid lightgray;
    width: 55%;
    height: 400px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 15px;

    h3{
        font-size: 28px;
        font-weight: 400;
        line-height: 33px;
        align-self: flex-start;

        margin-bottom: 10px;
    }
`;

const InputContainer = styled.div`
    width: 100%;
    padding: 10px;

    p{
        font-size: 14px;
        font-weight: 600;
    }

    input{
        width: 95%;
        height: 33px;
        padding-left: 5px;
        border-radius: 5px;
        border: 1px solid lightgray;
        margin-top: 5px;

        &:hover{
            border: 1px solid black;
        }
    }
`;


const SignUpButton = styled.button`
    width: 50%;
    height: 35px;
    font-size: 12px;
    margin-top: 20px;

    &:hover{
        background-color: #dfdfdf;
        border: 1px solid gray;
    }
`;

const LoginButton = styled.button`
    width: 70%;
    height: 35px;
    background-color: #f3b414;
    border: none;
    outline: none;
    border-radius: 10px;
    margin-top: 30px;

    &:hover{
        border: 2px solid black;
    }
`;

const InfoText = styled.p`
    font-size: 12px;
    width: 100%;
    word-wrap: normal;
    word-break: normal;
    margin-top: 20px;

    span{
        color: #426bc0;
    }
`;



export default Login