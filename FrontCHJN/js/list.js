function GetMokepones(afterRequest) {
    //Asíncrono
    let fetchM = fetch(
        "https://pokeapi.co/api/v2/pokemon?limit=10&offset=0"
    ).then((data) => {
        afterRequest(data)
    });
}



const listarpock = () => {
    const afterReq = (dataP) => {
        dataP.forEach(element => {
            console.log(element);
            let pokitem = `<div class="flex-item">
            <h2>THis is</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Libero, cum quisquam sunt reiciendis voluptate at aspernatur, vitae laborum quo obcaecati, inventore rem dolorum! Numquam eius dolorem illo blanditiis error recusandae.</p>
            </div>`;
        });
    }
    GetMokepones(afterReq)
};