export const canvas = document.querySelector("canvas");
export const ctx = canvas.getContext("2d");

export const width = (canvas.width = window.innerWidth);
export const height = (canvas.height = window.innerHeight);

export const config = {
    ctx: ctx,
    width: width,
    height: height
}