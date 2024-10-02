interface DisplayProps {
  displayText: string;
}

function Display({ displayText }: DisplayProps) {
  return (
    <div className="w-[97%] mx-auto my-2 h-[150px] bg-blue-300 border-[1px] border-solid border-black">
      {displayText}
    </div>
  );
}

export default Display;
