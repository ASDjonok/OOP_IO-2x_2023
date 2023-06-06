class Text {
 constructor(text) {
   this.text = [];
   const sentences = text.split(/[.?!;]/).filter((sentence) => sentence);
   for (const sentence of sentences) {
      this.text.push(new Sentence(sentence))
   }
 }

 getText() {
   let text = '';
   for (const sentence of this.text) {
     text += sentence.getSentence() + '. ';
   }
   return text;
 }

 getSortedText() {
   let words = [];
   const vowels = /[AaEeiOoUuYy]/g;

   for (const sentence of this.text) {
     words = words.concat(sentence.getWords());
   }
   const sortedWords = words.sort((first, second) => {
     const vowelsOfFirstWord = first.match(vowels)? first.match(vowels): [];
     const vowelsOfSecondWord =  second.match(vowels)? second.match(vowels): [];
     return  vowelsOfFirstWord.length-vowelsOfSecondWord.length;
   });
   return sortedWords.join(' ');
 }
}

class Sentence {
  constructor(sentence) {
    this.sentence = [];
    const words = sentence.split(/[\s,:]/).filter((word) => word);
    for (const word of words) {
      this.sentence.push(new Word(word));
    }
  }

  getSentence() {
    let sentence = '';
    for (const word of this.sentence) {
      sentence += word.getWord();
      if ( this.sentence[this.sentence.length-1] !== word) sentence += ' ';
    }
    return sentence;
  }

  getWords() {
    let words = [];
    for (const word of this.sentence) {
      words.push(word.getWord());
    }
    return words;
  }
}

class Word {
  constructor(word) {
    this.word = [];
    for (const symbol of word) {
      if (/[A-Za-z]/.test(symbol)){
        this.word.push(new Letter(symbol));
      } else if (/[0-9]/.test(symbol)) {
        this.word.push(new Number(symbol));
      }
    }
  }

  getWord() {
    let word = '';
    for (const symbol of this.word) {
      word += symbol.getSymbol();
    }
    return word
  }
}

class Letter {
  constructor(letter) {
    this.letter = letter;
  }

  getSymbol() {
    return this.letter;
  }
}

class Number {
  constructor(number) {
    this.number = number;
  }

  getSymbol() {
    return this.number;
  }
}
const text = new Text('In late September or October, Martina elevated Constans to co-emperor, but also raised Heraclonas\'s brother Tiberius to co-emperor alongside them. Despite these overtures, Valentinus entered Constantinople shortly thereafter, deposed Heraclonas and Martina, and then elevated Constans to sole emperor. Heraclonas, Martina, Tiberius, and Martinus are said by John of Nikiu to have been escorted forth with insolence. Valentinus had Martinus nose cut off, emasculated him, and then banished his family to Rhodes, where they stayed until their deaths. According to some sources, the stress of the surgery killed Martinus immediately.');
console.log(text.getText());
console.log('\n' + text.getSortedText());