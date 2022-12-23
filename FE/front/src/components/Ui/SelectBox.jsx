import React from 'react';
import styled from 'styled-components';

export default function SelectBox(props) {
  const handleChange = e => {
    // eslint-disable-next-line
    console.log(e.target.value);
    // eslint-disable-next-line
    props.setGeneration && props.setGeneration(e.target.value);
    // eslint-disable-next-line
    props.setCampus && props.setCampus(e.target.value);
  };
  return (
    <Select onChange={handleChange}>
      {/* eslint-disable-next-line */}
      {props.props?.map(option => (
        <option
          key={option.value}
          value={option.value}
          // eslint-disable-next-line
          defaultValue={props.defaultValue === option.value}
        >
          {option.name}
        </option>
      ))}
    </Select>
  );
}

let Select = styled.select`
  margin: 0;
  min-width: 0;
  display: block;
  width: 100%;
  padding: 8px 8px;
  font-size: inherit;
  line-height: inherit;
  border: 1px solid;
  border-radius: 4px;
  color: inherit;
  background-color: transparent;
  &:focus {
    border-color: red;
  }
`;
