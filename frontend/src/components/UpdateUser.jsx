import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from 'styled-components';
import Api from "../api/Api";

const UpdateUser = () => {
    const navigate = useNavigate()

    const [nome, setNome] = useState("");
    const [login, setLogin] = useState("");
    const [senha, setSenha] = useState("")

    const { id } = useParams();

    const data = {
        nome: nome,
        login: login,
        senha: senha
    };

    const onSubmit = async (e) => {
        e.preventDefault();

        Api.put(`/api/usuarios/update/${id}`, data).then((response) => {
            console.log(response.data);
            alert("Atualizado com sucesso!");
            localStorage.removeItem('token');
            navigate('/login')
            
            
        }).catch((error) => {
            console.log(error);
        })

    }

    return (
        <Container>
            <Logo onClick={() => navigate('/')}>
                <img src="/logo.png/" alt="" />
            </Logo>

            <FormContainer onSubmit={onSubmit}>
                <h3>Atualizar seus Dados</h3>

                <InputContainer>
                    <p>Nome</p>
                    <input type="text" onChange={(e) => setNome(e.target.value)} value={nome} />
                </InputContainer>

                <InputContainer>
                    <p>email</p>
                    <input type="email" onChange={(e) => setLogin(e.target.value)} value={login} />
                </InputContainer>

                <InputContainer>
                    <p>senha</p>
                    <input type="password" onChange={(e) => setSenha(e.target.value)} value={senha} />
                </InputContainer>
                <Button>Atualizar</Button>
            </FormContainer>
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

const Select = styled.select`
  width: 97%;
  height: 35px;
  margin-top: 5px;
  background: white;
  color: gray;
  
  font-size: 14px;
  border: none;

  option {
    color: black;
    background: white;
    display: flex;
    white-space: pre;
    min-height: 20px;
    padding: 0px 2px 1px;
  }
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
    height: fit-content;
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


const Button = styled.button`
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

export default UpdateUser