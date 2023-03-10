import React from 'react';
import Tabela from './Tabela';

const App: React.FC = () => {
  const data = [
    { id: 1, name: 'João', email: 'joao@gmail.com' },
    { id: 2, name: 'Maria', email: 'maria@gmail.com' },
    { id: 3, name: 'José', email: 'jose@gmail.com' },
  ];

  return <Tabela data={data} />;
}

export default App;
