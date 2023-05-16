import {React, useState, useEffect} from 'react'
import ModifyItem from './ModifyItem';
import DeleteItem from './DeleteItem';

export default function ViewItems() {

    const [items, setItems] = useState([]);

    useEffect(() => {
        const fetchAllProduct = async () =>{
            const response = await fetch('/app/item');
            const data = await response.json();
            console.log(data);
            setItems(data);
        }

        fetchAllProduct();
    }, []);
    
    const dispayData = items.map((item) => {
        return (
            <tr>
                <td className='text-center'>{item.itemName}</td>
                <td className='text-center'>{item.itemSellingPrice}</td>
                <td className='text-center'>{item.itemBuyingPrice}</td>
                <td className='text-center'>{item.itemStatus}</td>
                <td className='text-center'>
                    <div className="btn-group" role="group">
                        <ModifyItem />
                        <DeleteItem />
                    </div>
                </td>
            </tr>
        )
    })

    return (
        <div>
            <table className="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">ItemName</th>
                        <th scope="col">ItemSellingPrice</th>
                        <th scope="col">ItemBuyingPrice</th>
                        <th scope="col">AvailableStatus</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                {dispayData}
                </tbody>
            </table>
        </div>
    )
}
