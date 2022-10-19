import React from 'react'
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components'
import Api from '../api/Api';
import { useStateValue } from '../StateProvider';
import Footer from './Footer';
import Header from './Header';
import PaymentMethod from './PaymentMethod';


const Address = () => {

    const [{ }, dispatch] = useStateValue()
    const [nome, setNome] = useState("");
    const [telefone, setTelefone] = useState("");
    const [rua, setRua] = useState("");
    const [pontoDeReferencia, setPontoDeReferencia] = useState("");
    const [cidade, setCidade] = useState("");
    const [estado, setEstado] = useState("");
    const [numero, setNumero] = useState(0);
    const [userId, setUserId] = useState(0);

    const email = localStorage.getItem("email");

    Api.get(`/api/usuarios/email/${email}`).then((response) => {
        console.log(response.data.id);
        setUserId(response.data.id);
    }).catch((error) => {
        console.log(error);

    })

    const navigate = useNavigate()

    const data = {
        nome: nome,
        telefone: telefone,
        rua: rua,
        pontoDeReferencia: pontoDeReferencia,
        cidade: cidade,
        estado: estado,
        numero: numero,
        userId: userId
    }


    const onSubmit = async (e) => {
        e.preventDefault();

        dispatch({
            type: 'SET_ADRESS',
            item: {
                nome,
                telefone,
                rua,
                pontoDeReferencia,
                cidade,
                estado,
                numero
            }
        })
        await Api.post("/api/endereco/save", data).then((response) => {
            console.log(response.data);
        }).catch((error) => {
            alert("deu error")
            console.log(error);
        });

        navigate("/payment")

    }

    return (
        <Container>
            <Header />

            <Main>
                <FormContainer>
                    <InputContainer>
                        <p>Nome</p>
                        <input
                            onChange={(e) => setNome(e.target.value)}
                            type="text"
                            placeholder='John Cena'
                            value={nome} />
                    </InputContainer>

                    <InputContainer>
                        <p>Número de Telefone</p>
                        <input
                            onChange={(e) => setTelefone(e.target.value)}
                            type="text"
                            value={telefone}
                        />
                    </InputContainer>

                    <InputContainer>
                        <p>Rua</p>
                        <input
                            onChange={(e) => setRua(e.target.value)}
                            type="text"
                            value={rua}
                        />
                    </InputContainer>

                    <InputContainer>
                        <p>Ponto de Referência</p>
                        <input
                            onChange={(e) => setPontoDeReferencia(e.target.value)}
                            type="text"
                            value={pontoDeReferencia}
                        />
                    </InputContainer>

                    <InputContainer>
                        <p>Cidade</p>
                        <input
                            onChange={(e) => setCidade(e.target.value)}
                            type="text"
                            value={cidade}
                        />
                    </InputContainer>

                    <InputContainer>
                        <p>Estado</p>
                        <input
                            onChange={(e) => setEstado(e.target.value)}
                            type="text"
                            value={estado}
                        />
                    </InputContainer>


                    <InputContainer>
                        <p>Numero</p>
                        <input
                            onChange={(e) => setNumero(e.target.value)}
                            type="number"
                            value={numero}
                        />
                    </InputContainer>

                    <button onClick={onSubmit}>Entegar neste endereço</button>
                </FormContainer>
            </Main>

            <PaymentMethod />

            <Footer />
        </Container>
    )
}

const Container = styled.div`
  width: 100%;
  margin: auto;
  background-color: rgb(234, 237, 237);
  position: relative;
`;

const Main = styled.div`
  padding: 15px;
  margin: 50px 0 60px 0;
`;


const FormContainer = styled.div`
   border: 1px solid lightgray;
   width: 55%;
   min-width: 400px;
   height: fit-content;
   display: flex;
   flex-direction: column;
   align-items: center;
   justify-content: center;
   padding: 15px;
   background-color: #fff;
   margin: auto;

   button{
    align-self: flex-start;
    height: 33px;
    width: 250px;
    margin-top: 20px;
    background-color: orange;
    border: none;
    outline: none;
    border-radius: 5px;
    cursor: pointer;

    &:hover{
            border: 2px solid black;
        }

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
            border: 1px solid 
        }
    }
`;



export default Address