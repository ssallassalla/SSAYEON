import React, { useState } from "react";
import ReactQuill from "react-quill";
import "react-quill/dist/quill.snow.css";
import styled from "styled-components";

const modules = {
  toolbar: [
    [{ header: [1, 2, false] }],
    ["bold", "blockquote"],
    [
      { list: "ordered" },
      { list: "bullet" },
    //   { indent: "-1" },
    //   { indent: "+1" },
    ],
    ["link", "image"],
    [{ color: [] }, { background: [] }], // dropdown with defaults from theme
    ["clean"],
    ["code-block"]
  ],
};
// 툴바 옵션 : https://quilljs.com/docs/modules/toolbar/
const formats = [
  //'font',
  "header",
  "bold",
  "blockquote",
  "list",
  "bullet",
  "image",
  "color",
  "background",
  "code-block",
];

function Editor() {
  const [value, setValue] = useState("");

  const handleChange = (content, delta, source, editor) => {
    // console.log(JSON.stringify(editor.getContents())); // delta 사용시
    setValue(editor.getHTML());
  };

  return (
    <Container>
      <ReactQuill
        style={{ width: "900px", height: "350px" }}
        theme="snow"
        modules={modules}
        formats={formats}
        value={value}
        onChange={handleChange}
      />
    </Container>
  );
}

const Container = styled.div`
  
  
`;

export default Editor;