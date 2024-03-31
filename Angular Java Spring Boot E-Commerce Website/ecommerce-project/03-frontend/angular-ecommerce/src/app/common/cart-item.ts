import { Product } from './product';

export class CartItem {

   /* constructor(public id: string,
                public name:string,
                public imageUrl: string,
                public unitPrice: number,
   		public quantity: number = 1) {
*/
    id: string;
    name: string;
    imageUrl: string;
    unitPrice: number;

    quantity: number;

    constructor(product: Product) {
        this.id = product.id;
        this.name = product.name;
        this.imageUrl = product.imageUrl;
        this.unitPrice = product.unitPrice;

        this.quantity = 1;

    }
}
