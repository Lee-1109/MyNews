function run(title,content){
    let rightDiv=document.getElementById("right");
    let titl=document.createElement("h4");
    titl.style.width='100%';
    titl.style.color='red';

    titl.value=title;
    rightDiv.innerText=title+content;
}

function verifyConfirm() {
    let input = prompt("please input you password to verify you identify:").value;
    if(input=="991109"){
        alert("confirm pass");
        return true;
    }else {
        alert("password error");
        return false;
    }


}