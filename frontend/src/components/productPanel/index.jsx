import React from "react";
import Rating from '@material-ui/lab/Rating';

import { 
    PanelProduct,
    BookDescription,
    BookInfo,
    BookMenu,
    RelatedBooks,
    Description,
    BookImg,
    Action
} from './styled'

const Panel = () => {

    const price = 80

    const title = "Harry Potter"

    return(
        <PanelProduct>
            <BookDescription>
                <BookImg/>
                
                <Description>
                    <h1>{title}</h1>

                    <Rating name="half-rating-read" defaultValue={3} precision={0.5} readOnly />

                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea itaque obcaecati, at molestias ratione praesentium aliquid iusto provident enim libero ex minima nam iste, delectus porro nulla similique optio aut.
                    </p>

                    <Action>
                        <p>R$ {price}</p>
                        <button>Adicionar ao Carrinho</button>
                    </Action>
                </Description>
                
            </BookDescription>
            <BookInfo>
                <BookMenu>
                    <p>Deixe o seu comentario</p>
                </BookMenu>

                <RelatedBooks>
                    <h3>Mais Livros:</h3>
                </RelatedBooks>

            </BookInfo>

        </PanelProduct>

    )
}

export default Panel