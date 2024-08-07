console.log("welcome to Music Litener");
let songindex=0;
let gif=document.getElementById('gif');
let audioelement=new Audio('songs/1.mp3');
let masterplay=document.getElementById("masterplay");
let myprogressbar=document.getElementById("myprogressbar");
let songItem=Array.from(document.getElementsByClassName('songItem'));
let songs=[
    {songname:"A",filepath:"songs/1.mp3",coverpath:"covers/1.jpg"},
    {songname:"B",filepath:"songs/2.mp3",coverpath:"covers/2.jpg"},
    {songname:"C",filepath:"songs/3.mp3",coverpath:"covers/3.jpg"},
    {songname:"D",filepath:"songs/4.mp3",coverpath:"covers/4.jpg"},
    {songname:"E",filepath:"songs/5.mp3",coverpath:"covers/5.jpg"},
    {songname:"F",filepath:"songs/6.mp3",coverpath:"covers/6.jpg"},
    {songname:"G",filepath:"songs/7.mp3",coverpath:"covers/7.jpg"},
    {songname:"H",filepath:"songs/8.mp3",coverpath:"covers/8.jpg"},
    {songname:"I",filepath:"songs/9.mp3",coverpath:"covers/9.jpg"},
    {songname:"J",filepath:"songs/10.mp3",coverpath:"covers/10.jpg"},
];
songItem.forEach((element,i)=>{
    element.getElementsByTagName("img")[0].src=songs[i].coverpath;
    element.getElementsByClassName("songname")[0].innerText=songs[i].songname;
})
masterplay.addEventListener('click', ()=>{
    if(audioelement.paused || audioelement.currentTime<=0)
    {
        audioelement.play();
        masterplay.classList.remove('fa-play-circle');
        masterplay.classList.add('fa-pause-circle');
        gif.style.opacity=1;
    }
    else{
        audioelement.pause();
        masterplay.classList.remove('fa-pause-circle');
        masterplay.classList.add('fa-play-circle');
        gif.style.opacity=0;
    }
})
audioelement.addEventListener('timeupdate',()=>
{
    progress=parseInt((audioelement.currentTime/audioelement.duration)*100);
    myprogressbar.value=progress;
})
myprogressbar.addEventListener('change', ()=>{
    audioelement.currentTime=(myprogressbar.value * audioelement.duration)/100;
})
const makeallplays= ()=>{
    Array.from(document.getElementsByClassName("songitemplay")).forEach((element)=>{
        element.classList.remove('fa-pause-circle');
        element.classList.add('fa-play-circle');
    })
}
Array.from(document.getElementsByClassName("songitemplay")).forEach((element)=>{
    element.addEventListener('click',(e)=>{
        makeallplays();
        songindex=parseInt(e.target.id);
        e.target.classList.remove('fa-play-circle');
        e.target.classList.add('fa-pause-circle');
        audioelement.src=`songs/${songindex}.mp3`;
        mastersong.innerText=songs[songindex].songname;
        audioelement.currentTime=0;
        audioelement.play();
        masterplay.classList.remove('fa-play-circle');
        masterplay.classList.add('fa-pause-circle');
        gif.style.opacity=1;
    })
})
document.getElementById('next').addEventListener('click', ()=>{
    if(songindex>=9)
    {
        songindex=0;
    }
    else{
        songindex +=1;
    }
    audioelement.src=`songs/${songindex}.mp3`;
    mastersong.innerText=songs[songindex].songname;
    audioelement.currentTime=0;
    audioelement.play();
    masterplay.classList.remove('fa-play-circle');
    masterplay.classList.add('fa-pause-circle');
})
document.getElementById('previous').addEventListener('click', ()=>{
    if(songindex<=0)
    {
        songindex=0;
    }
    else{
        songindex -=1;
    }
    audioelement.src=`songs/${songindex}.mp3`;
    mastersong.innerText=songs[songindex].songname;
    audioelement.currentTime=0;
    audioelement.play();
    masterplay.classList.remove('fa-play-circle');
    masterplay.classList.add('fa-pause-circle');
})
