//C17 = 2131 % 17 = 6; Відсортувати слова заданого тексту за зростанням кількості голосних літер.

import create from 'prompt-sync';
const prompt = create();

class Sentence {
  constructor() {
    this.sentence = prompt("Input sentence: ");
  }
  sort() {
    const words = this.sentence.split(/[\s.?!,;]/).filter((word) => word);
    const vowels = /[AaEeiOoUuYy]/g
    const sortedWords = words.sort((first, second) => {
      const vowelsOfFirstWord = first.match(vowels)? first.match(vowels): [];
      const vowelsOfSecondWord =  second.match(vowels)? second.match(vowels): [];
      return  vowelsOfFirstWord.length-vowelsOfSecondWord.length;
    });
    return sortedWords.join(' ');
  }
}

const sentence = new Sentence;
console.log(sentence.sort())