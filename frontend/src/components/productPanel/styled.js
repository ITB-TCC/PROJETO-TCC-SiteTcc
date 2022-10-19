import styled from "styled-components";

export const PanelProduct = styled.div`
    
    width: 1184px;
    height: 100%;
    margin: auto;
    margin-top: 30px;
`
export const BookDescription = styled.div`
    display: flex;
    justify-content: space-between;
`
export const BookInfo = styled.div`
    margin-top: 30px;
    display: flex;
    justify-content: space-between;

`
export const BookMenu = styled.div`
    width: 75%;
`
export const RelatedBooks = styled.div`
    width: 20%;

`
export const Description = styled.div`
    display: flex;
    flex-direction: column;
    padding: 5px;
    width: 75%;
    > p {
        width: auto;
        display: block;
    }

    > h1 {
        width: auto;
        display: block;
    }
`

export const Action = styled.div`
    display: flex;
    justify-content: space-between;
    margin-top: auto;

    p {
        font-size: 30px;
    }

    button{
        width: 150px;
        height: 33px;
        background-color: #fa8900;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        

        &:hover{
            border: 2px solid black;
        }

    }

`
export const BookImg = styled.img`
    width: 20%;
    height: 300px;
`