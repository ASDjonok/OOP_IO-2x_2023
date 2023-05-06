fn main() {
    // use text_io::scan;
    use text_io::read;

    print!("Input: ");

    // read until a whitespace and try to convert what was read into an i32
    let a: i32 = read!();

    /* let i: u32;
    print!("Input: ");
    scan!("{}", i); */

    println!("You have input: {}", a);
}
