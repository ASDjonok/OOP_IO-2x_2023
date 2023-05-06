fn main() {
    // use text_io::scan;
    use text_io::read;

    print!("Enter m: ");
    let m: f32 = read!();

    print!("Enter n: ");
    let n: f32 = read!();

    print!("Enter a: ");
    let a: f32 = read!();

    print!("Enter b: ");
    let b: f32 = read!();

    let s: f32 = ((b + m) / 2.0) * (m - b + 1.0) * (n - a + 1.0);

    println!("S= {}", s);
}
